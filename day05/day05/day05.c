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
//	printf("��һ�����֣�\n");
//	while (1)       //for(i=1;i==1;)
//	{
//		scanf("%d", &input);
//		if (input > num)
//		{
//			printf("�´��ˣ�\n");
//		}
//		else if (input < num)
//		{
//			printf("��С�ˣ�\n");
//		}
//		else
//		{
//			printf("�����ˣ�\n");
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
//		printf("����������ѡ��\n");
//		scanf("%d", &i);
//		switch (i)
//		{
//		case 1:
//			game();
//			break;
//		case 0:
//			printf("�˳���Ϸ\n");
//			break;
//		default:
//			printf("ѡ��������������룺\n");
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
//	printf("������һ����10��Ԫ�ص��������飺\n");
//	for (i = 0; i < 10; i++)
//		scanf("%d", &arr[i]);
//	right = sizeof(arr) / sizeof(arr[0]) - 1;
//	printf("������Ҫ���ҵ�����\n");
//	scanf("%d", &k);
//	ret = search(arr, left, right, k);
//	if (ret==-1) printf("�Ҳ���\n");
//	else printf("�ҵ��ˣ��±��ǣ�%d\n", ret);
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
//		printf("���������룺\n");
//		scanf("%s", arr);
//		if (0 == strcmp(arr, key))
//		{
//			printf("��½�ɹ���\n");
//			break;
//		}
//		else 
//		{ 
//			if (i<2)
//			printf("��������㻹��%d�λ��ᣡ\n", (change-i));
//		}
//	}
//	if (i == 3)
//			printf("�˳���¼��\n");
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
	printf("������һ���ַ���\n");
	while ((ch = getchar()) != EOF)
	{
		/*if (ch >= '0'&&ch <= '9')  //�������������
			break;  */   //int getchar�õ��ַ��������ַ���Ӧ��ASCII��ֵ
		if (ch >= 'a'&&ch <= 'z')
			ch -= 32;
		else if (ch >= 'A'&&ch <= 'Z')
			ch += 32;
		//else ch = '0';
		putchar(ch);   //putchar(int)->���int��ӦASCII��ֵ���ַ�
	}
	system("pause");
	return 0;
}

