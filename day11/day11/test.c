#define  _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>


int main()
{
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
	for (a = 1; a < 6; a++)
	{
		for (b = 1; b < 6; b++)
		{
			for (c = 1; c < 6; c++)
			{
				for (d = 1; d < 6; d++)
				{
					for (e = 1; e < 6; e++)
					{
						if (((b == 2) + (a == 3)) && ((b == 2) + (e == 4)) && ((c == 1) + (d == 2)) && ((c == 5) + (d == 3)) && ((e == 4) + (a == 1)))
						{
							if (a*b*c*d*e == 120)
							{
								printf("A是第%d名\n",a);
								printf("B是第%d名\n",b);
								printf("C是第%d名\n",c);
								printf("D是第%d名\n",d);
								printf("E是第%d名\n",e);
								printf("\n");
							}
						}
					}
				}
			}
		}
	}
	system("pause");
	return 0;
}


int main()
{
	int k = 0;
	for (k = 'a'; k < 'd'; k++)
	{
		if (((k != 'a') + (k == 'c') + (k == 'd') + (k != 'd')) == 3)
		{
			printf("凶手是 %c\n", k);
		}
	}
	system("pause");
	return 0;
}



int main()
{
	int arr[50][50] = { 0 };
	int i = 0;
	int j = 0;
	int n = 0;
	printf("请输入想要打印的行数：");
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		arr[i][0] = 1;
		arr[i][i] = 1;
	}
	for (i = 1; i < n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}
	}
	for (i = 0; i < n; i++)
	{
		for (j = 0; j <=i; j++)
		{
			printf("%3d ", arr[i][j]);
		}
		printf("\n");
	}
	system("pause");
	return 0;
}