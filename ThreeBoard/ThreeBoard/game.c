#define  _CRT_SECURE_NO_WARNINGS 1
#include"game.h"

void menu()
{
	printf("************************\n");
	printf("*******  1.PLAY  *******\n");
	printf("*******  0.EXIT  *******\n");
	printf("************************\n");
}

void game()
{
	char board[row][col] = { 0 };
	char ret = 0;
	int ret1 = 0;
	InitBoard(board); 
	DisplayBoard(board);
	while (1)
	{
		PlayerMove(board);
		DisplayBoard(board);
		ret = IsWin(board);
		ret1 = IsFull(board);
		if (ret1 == 1 && ret != '*'&&ret != '0')
		{
			printf("平局\n");
			break;
		}
		else if (ret == '*')
		{
			printf("Player Win\n");
			break;
		}
		else if (ret == '0')
		{
			printf("Computer Win\n");
			break;
		}
		ComputerMove(board);
		DisplayBoard(board);
		ret = IsWin(board);
		ret1 = IsFull(board);
		if (ret1 == 1 && ret != '*'&&ret != '0')
		{
			printf("平局\n");
			break;
		}
		else if (ret == '*')
		{
			printf("Player Win\n");
			break;
		}
		else if (ret == '0')
		{
			printf("Computer Win\n");
			break;
		}
	}
}

void InitBoard(char board[row][col])
{
	memset(&board[0][0], ' ', row*col*sizeof(board[0][0]));
}

void DisplayBoard(char board[row][col])
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (i < 2)
			{
				printf("_%c_", board[i][j]);
			}
			else
				printf(" %c ", board[i][j]);
			if (j < col - 1)
				printf("|");
		}
		printf("\n");
	}
}

void PlayerMove(char board[row][col])
{
	int x = 0;
	int y = 0;
	while (1)
	{
		printf("请输入坐标：");
		scanf("%d %d", &x, &y);
		if (x>0&&x<(row+1)&&y>0&&y<(col+1))
		{
			if (board[x - 1][y - 1] == ' ')
			{
				board[x - 1][y - 1] = '*';
				break;
			}
		}
		else
			printf("输入错误！\n");
	}
	printf("\n");
}

void ComputerMove(char board[row][col])
{
	int x = 0;
	int y = 0;
	while (1)
	{
		x = rand() % row;
		y = rand() % col;
		if (board[x][y] == ' ')
		{
			board[x][y] = '0';
			break;
		}
	}
	printf("\n");
}

char IsWin(char board[row][col])
{
	int i = 0;
	for (i = 0; i < row; i++)
	{
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
		{
			return board[i][0];
			break;
		}
	}
	for (i = 0; i < col; i++)
	{
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
		{
			return board[0][i];
			break;
		}
	}
	if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
		return board[0][0];
	else if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
		return board[0][2];
	else return' ';
}

int IsFull(char board[row][col])
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')
				return 0;
		}
	}
	return 1;
}





