#define  _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//#include<stdlib.h>
//#include<time.h>
//
//void menu()
//{
//	printf("**********************\n");
//	printf("** 1.play    0.exit **\n");
//	printf("**********************\n");
//}
//
//void game()
//{
//	int num = 0;
//	int input = 0;
//	num = rand() % 100 + 1;
//	printf("猜一个数字：\n");
//	while (1)       //for(i=1;i==1;)
//	{
//		scanf("%d", &input);
//		if (input > num)
//		{
//			printf("猜大了！\n");
//		}
//		else if (input < num)
//		{
//			printf("猜小了！\n");
//		}
//		else
//		{
//			printf("猜中了！\n");
//			break;
//		}
//	}
//}
//
//int main()
//{
//	int i = 0;
//	srand((unsigned int)time NULL);
//	do
//	{
//		menu();
//		printf("请输入您的选择：\n");
//		scanf("%d", &i);
//		switch (i)
//		{
//		case 1:
//			game();
//			break;
//		case 0:
//			printf("退出游戏\n");
//			break;
//		default:
//			printf("选择错误，请重新输入：\n");
//			break;
//		}
//	} while (i);
//	system("pause");
//	return 0;
//}


//#include<stdio.h>
//#include<stdlib.h>
//
//int search(int arr[], int left, int right, int k)
//{	while (left <= right)
//	{
//		int mid = 0;
//		mid = left + (right - left) / 2;
//		if (k > arr[mid])
//		{
//			left = mid + 1;
//		}
//		else if (k < arr[mid])
//		{
//			right = mid - 1;
//		}
//		else
//		{
//			return mid;
//		}
//	}
//     return -1;
//}
//int main()
//{
//	int arr[10] = { 0 };
//	int left = 0;
//	int right = 0;
//	int ret = 0;
//	int i = 0;
//	int k = 0;
//	printf("请输入一个含10各元素的有序数组：\n");
//	for (i = 0; i < 10; i++)
//		scanf("%d", &arr[i]);
//	right = sizeof(arr) / sizeof(arr[0]) - 1;
//	printf("请输入要查找的数：\n");
//	scanf("%d", &k);
//	ret = search(arr, left, right, k);
//	if (ret==-1) printf("找不到\n");
//	else printf("找到了，下标是：%d\n", ret);
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//#include<string.h>
//int main()
//{
//	char arr[10] = { 0 };
//	char key[] = "123456";
//	int i = 0;
//	int change = 2;
//	for (i = 0; i < 3;i++)
//	{
//		printf("请输入密码：\n");
//		scanf("%s", arr);
//		if (0 == strcmp(arr, key))
//		{
//			printf("登陆成功！\n");
//			break;
//		}
//		else 
//		{ 
//			if (i<2)
//			printf("密码错误！你还有%d次机会！\n", (change-i));
//		}
//	}
//	if (i == 3)
//			printf("退出登录！\n");
//	system("pause");
//	return 0;
//}
//
//
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int ch = 0;
	printf("请输入一串字符：\n");
	while ((ch = getchar()) != EOF)
	{
		/*if (ch >= '0'&&ch <= '9')  //不作处理不列情况
			break;  */   //int getchar得到字符，返回字符对应的ASCII码值
		if (ch >= 'a'&&ch <= 'z')
			ch -= 32;
		else if (ch >= 'A'&&ch <= 'Z')
			ch += 32;
		//else ch = '0';
		putchar(ch);   //putchar(int)->输出int对应ASCII码值的字符
	}
	system("pause");
	return 0;
}

