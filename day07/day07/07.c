#define  _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//#include<stdlib.h>
//
//int fib1(int n)
//{
//	if (n <= 2)
//		return 1;
//	else
//		return fib1(n - 1) + fib1(n - 2);
//}
//
//int fib2(int n)
//{
//	int a = 1;
//	int b = 1;
//	int c = 0;
//	int i = 0;
//	for (i = 0; i < n - 2; i++)
//	{
//		c = a + b;
//		a = b;
//		b = c;
//	}
//	return c;
//}
//
//int main()
//{
//	int n = 0;
//	int ret1 = 0;
//	int ret2 = 0;
//	printf("�����룺");
//	scanf("%d", &n);
//	ret1 = fib1(n);
//	ret2 = fib2(n);
//	printf("��%d��쳲�������Ϊ��%d\n",n,ret1);
//	printf("��%d��쳲�������Ϊ��%d\n",n,ret2);
//	system("pause");
//	return 0;
//}


#include<stdio.h>
#include<stdlib.h>

int pow(int n, int k)
{
	if (k > 0)   
	{
		return n*pow(n, k -1);
	}
	else
		return 1;   //n^0=1�����
}

int main()
{
	int n = 0;
	int k = 0;
	int ret = 0;
	printf("������n��k��");
	scanf("%d %d", &n, &k);
	ret = pow(n, k);
	printf("%d^%d=%d\n", n, k, ret);
	system("pause");
	return 0;
}

//
//#include<stdio.h>
//#include<stdlib.h>
//
//int DigitSum(int n)
//{
//	if (n < 10)
//		return n;
//	else
//	{
//		return (n%10)+DigitSum(n / 10);
//	}
//}
//
//int main()
//{
//	int n = 0;
//	int ret = 0;
//	printf("���������֣�");
//	scanf("%d", &n);
//    ret=DigitSum(n);
//	printf("sum=%d\n", ret);
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//
//void Reverse_string(char *string)
//{
//	if (*string != '\0')
//	{
//		Reverse_string(string + 1);
//	}
//	printf("%c", *string);
//}
//
//int main()
//{
//	char arr[10] = { 0 };
//	char *p = arr;
//	printf("������һ���ַ���");
//	scanf("%s", arr);
//	Reverse_string(p);
//	printf("\n");
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//
//int strlen1(char *p)
//{
//	if (*p != '\0')
//		return 1 + strlen1(p + 1);
//	else
//		return 0;
//}
//
//int strlen2(char *p)
//{
//	int count = 0;
//	while (*p != '\0')
//	{
//		count++;
//		p++;
//	}
//	return count;
//}
//
//int main()
//{
//	char arr[10] = { 0 };
//	char *p = arr;
//	int ret1 = 0;
//	int ret2 = 0;
//	printf("������һ���ַ���");
//	scanf("%s", arr);
//	ret1 = strlen1(p);
//	ret2 = strlen2(p);
//	printf("�ַ�����Ϊ��%d\n",ret1);
//	printf("�ַ�����Ϊ��%d\n", ret2);
//	system("pause");
//	return 0;
//}
//
//
//#include<stdio.h>
//#include<stdlib.h>
//
//int fab1(int n)
//{
//	if (n < 2)
//		return 1;
//	else
//		return n*fab1(n - 1);
//}
//
//int fab2(int n)
//{
//	int i = 1;
//	int sum = 1;
//	for (i = 1; i <=n; i++)
//	{
//		sum *= i;
//	}
//	return sum;
//}
//
//int main()
//{
//	int n = 0;
//	int ret1 = 0;
//	int ret2 = 0;
//	printf("������Ҫ��������֣�");
//	scanf("%d", &n);
//	ret1 = fab1(n);
//	ret2 = fab2(n);
//	printf("%d��=%d\n", n, ret1);
//	printf("%d��=%d\n", n, ret2);
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
//	int n = 0;
//	printf("������Ҫ��ӡ�����֣�");
//	scanf("%d", &n);
//	printf("��ӡ�����");
//	print(n);
//	printf("\n");
//	system("pause");
//	return 0;
//}