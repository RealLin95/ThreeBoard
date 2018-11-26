#define  _CRT_SECURE_NO_WARNINGS 1

#include"game.h"

int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("Please input:");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏！\n");
			break;
		default:
			printf("选择错误！请重新输入:\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}