#define  _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//#include<stdlib.h>
//#include<math.h>
//
//int count_one_bits(int num)
//{
//	int count = 0;
//	while (num)
//	{
//		num = num&(num - 1);
//		count++;
//	}
//	return count;
//}
//
//int main()
//{
//	int num = 0;
//	int ret = 0;
//	printf("请输入一个数字：\n");
//	scanf("%d", &num);
//	ret = count_one_bits(num);
//	printf("数字二进制中1的个数为 %d 个\n", ret);
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//int main()
//{
//	int num = 0;
//	int i = 0;
//	int x = 0;
//	printf("请输入一个数字：");
//	scanf("%d", &num);
//	printf("偶数位二进制序列为：");
//	for (i = 0; i <32; i+=2)
//	{
//		x = num >> (31 - i);
//		printf("%d ", (x & 1));
//	}
//	printf("\n");
//	printf("奇数位二进制序列为：");
//	for (i = 0; i <32; i+=2)
//	{
//		x = num >> (30 - i);
//		printf("%d ", (x & 1));
//	}
//	printf("\n");
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//
//void print(int n)
//{
//	if (n > 9)
//	{
//		print(n / 10);
//	}
//	printf("%d ", n % 10);
//}
//
//int main()
//{
//	int num = 0;
//	printf("请输入想打印的数字：");
//	scanf("%d", &num);
//	print(num);
//	printf("\n");
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//#include<math.h>
//
//int count_one_bits(int num)
//{
//	int count = 0;
//	while (num)
//	{
//		num = num&(num - 1);
//		count++;
//	}
//	return count;
//}
//
//int main()
//{
//	int a = 0;
//	int b = 0;
//	int num = 0;
//	int ret = 0;
//	printf("请输入a和b：");
//	scanf("%d %d", &a, &b);
//	num = a^b;
//	ret = count_one_bits(num);
//	printf("%d与%d的二进制有 %d 位不同\n", a, b, ret);
//	system("pause");
//	return 0;
//}


#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
	int num = 0;
	int i = 0;
	scanf("%d", &num);
	for (i = 0; i < 32; i+=2)
	{
		printf("%d ", ((num >> (31 - i)) & 1));
	}
	printf("\n");
	for (i = 0; i < 32; i+=2)
	{
		printf("%d ", ((num >> (30 - i)) & 1));
	}
	printf("\n");
	system("pause");
	return 0;
}