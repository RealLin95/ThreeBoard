#define  _CRT_SECURE_NO_WARNINGS 1

#include"game.h"

void menu()
{
	printf("**********************\n");
	printf("******  1.PlAY  ******\n");
	printf("******  0.EXIT  ******\n");
	printf("**********************\n");
}

void game()
{
	char Showboard[ROWS][COLS] = { 0 };
	char Mineboard[ROWS][COLS] = { 0 };
	InitBoard(Showboard, '*');
	DisplayBoard(Showboard);
	InitBoard(Mineboard,'0');
	//DisplayBoard(Mineboard);
	SetMine(Mineboard);
	//DisplayBoard(Mineboard);
	FindMine(Mineboard,Showboard);
}

void InitBoard(char arr[ROWS][COLS],char ch) 
{
	////memset(&arr[0][0], ch, ROWS*COLS*sizeof(arr[0][0]));
	int i = 0;
	int j = 0;
	for (i = 0; i < ROWS; i++)
	{
		for (j = 0; j < COLS; j++)
		{
			arr[i][j] = ch;
		}
	}
}

void DisplayBoard(char arr[ROWS][COLS])
{
	int k = 0;
	int i = 0;
	int j = 0;
	for (k = 0; k <=ROW; k++)
		printf("%d ", k);
	printf("\n");
	for (i = 1; i <=ROW; i++)
	{
		printf("%d ", i);
		for (j = 1; j <=COL; j++)
		{
			printf("%c ", arr[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void SetMine(char arr[ROWS][COLS])
{
	int x = 0;
	int y = 0;
	int count = 0;
	while (count < Count)
	{
		x = rand() % ROW + 1;
		y = rand() % COL + 1;
		if (arr[x][y] != '1')
		{
			arr[x][y] = '1';
			count++;
		}
	}
}

void FindMine(char arr1[ROWS][COLS], char arr2[ROWS][COLS])
{
	int x = 0;
	int y = 0;
	int win = 0;
	int* p = &win;
	int count = 0;
	while (1)
	{
		printf("请输入坐标：");
		scanf("%d %d", &x, &y);
		if (x >= 1 && x <= 9 && y >= 1 && y <= 9)
		{
			count++;
			if (count == 1 && arr1[x][y] == '1')
			{
				FirstAlive(arr1,arr2, x, y,p);
			}
			else if (arr1[x][y] == '1')
			{
				printf("很遗憾！你被炸死了\n");
				DisplayBoard(arr1);
				break;
			}
			else if (arr1[x][y] == '0')
			{
					IfOpen(arr1, arr2, x, y, p);
			}
			DisplayBoard(arr2);
			if (win == (ROW*COL - Count))
			{
				printf("恭喜你！扫雷成功！\n");
				DisplayBoard(arr1);
				break;
			}
		}
	}
	printf("\n");
}

void FirstAlive(char arr1[ROWS][COLS],char arr2[ROWS][COLS],int m,int n,int* p)
{
	int count = 1;
	int x = 0;
	int y = 0;
	arr1[m][n] = '0';
	while (count)
	{
		x = rand() % ROW + 1;
		y = rand() % COL + 1;
		if (x!=m&&y!=n&&arr1[x][y] != '1')
		{
			arr1[x][y] = '1';
			count--;
		}
	}
	DisplayBoard(arr1);
	IfOpen(arr1, arr2, m, n,p);
}

void IfOpen(char arr1[ROWS][COLS],char arr2[ROWS][COLS],int x,int y,int* p)
{
	int i = 0;
	int j = 0;
	int count = 0;
	count=GetMineCount(arr1, x, y);
	if (0==count)
	{
		arr2[x][y] = ' ';
		(*p)++;
		for (i = x - 1; i <= x + 1; i++)
		{
			for (j = y - 1; j <= y + 1; j++)
			{
				if (arr2[i][j] == '*')
				{
					IfOpen(arr1, arr2, i, j, p);
				}
			}
		}
	}
	else
	{
		arr2[x][y] = count + '0';
		(*p)++;
	}
}

int GetMineCount(char arr[ROWS][COLS],int x, int y)
{
	int count = 0;
	count = arr[x - 1][y - 1] + arr[x - 1][y] + arr[x - 1][y + 1] + arr[x][y - 1] + arr[x][y + 1] + arr[x + 1][y - 1] + arr[x + 1][y] + arr[x + 1][y + 1]-8*'0';
	return(count);
}
