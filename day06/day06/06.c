#define  _CRT_SECURE_NO_WARNINGS 1
//#include<stdio.h>
//#include<stdlib.h>
//
//void Display(int m)
//{
//	int i = 1;
//	int j = 1;
//	for (i = 1; i <= m; i++)
//	{
//		for (j = 1; j <= i; j++)
//		{
//			printf("%d*%d=%d ", i, j, i*j);
//		}
//		printf("\n");
//	}
//}
//
//int main()
//{
//	int row = 0;
//	printf("��������Ҫ��ӡ��������\n");
//	scanf("%d", &row);
//	Display(row);
//	system("pause");
//	return 0;
//}

//
//#include<stdio.h>
//#include<stdlib.h>
//
//void change(int *m,int *n)
//{
//	int temp = 0;
//	temp = *m;
//	*m = *n;
//	*n = temp;
//}
//
//int main()
//{
//	int a = 0;
//	int b = 0;
//	printf("��������������\n");
//	scanf("%d %d", &a, &b);
//	change(&a, &b);
//	printf("a=%d b=%d\n", a, b);
//	system("pause");
//	return 0;
//}
////
//
//#include<stdio.h>
//#include<stdlib.h>
//
//int leapyear(int y)
//{
//	if(y%400==0||(y%100!=0&&y%4==0))
//		return 1;
//	else return -1;
//}
//
//int main()
//{
//	int year=0;
//	int ret=0;
//	printf("��������ݣ�\n");
//	scanf("%d",&year);
//    ret=leapyear(year);
//	if(1==ret) printf("%d������\n",year);
//	else printf("%d��������\n",year);
//	system("pause");
//	return 0;
//}
//
//
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define k 10

void Init(int arr[])
{
	int i = 0;
	printf("������Ԫ�أ�\n");
	for (i = 0; i<k; i++)
		scanf("%d", &arr[i]);
	printf("�������ʼ��Ϊ��\n");
	for (i = 0; i<k; i++)
		printf("%d ", arr[i]);
	printf("\n");
}
//
//void Reverse(int arr[])
//{
//	int i = 0;
//	int brr[10] = { 0 };
//	printf("������Ԫ�����ã�\n");
//	for (i = 0; i<k; i++)
//	{
//		brr[i] = arr[k - 1 - i];
//	}
//	for (i = 0; i<k; i++)
//		printf("%d ", brr[i]);
//	printf("\n");
//}
//

void Reverse(int arr[])
{
	int i = 0;
	int l = 0;
	int r = k - 1;
	int temp = 0;
	printf("�������飺\n");
	while (l < r)
	{
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		l++;
		r--;
	}
	for (i = 0; i < k; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}


void Empty(int arr[])
{
	int i = 0;
	printf("������飺\n");
	for (i = 0; i<k; i++)
		arr[i] = 0;
	for (i = 0; i<k; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

int main()
{
	int arr[10] = { 0 };
	Init(arr);
	Reverse(arr);
	Empty(arr);
	system("pause");
	return 0;
}


//#include<stdio.h>
//#include<stdlib.h>
//#include<math.h>
//
//int sushu(int n)
//{
//	int i=0;
//	int k=0;
//	k=sqrt(n);
//	for(i=2;i<=k;i++)
//	{
//        if(n%i==0)
//			return -1;
//	}
//	if(i>k)
//		return 1;
//}
//
//int main()
//{
//	int num=0;
//	int ret=0;
//	printf("���������֣�\n");
//	scanf("%d",&num);
//    ret=sushu(num);
//	if(1==ret) printf("%d������\n",num);
//	else printf("%d��������\n",num);
//	system("pause");
//	return 0;
//}