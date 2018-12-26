#define  _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>

void Ofirst(int* a)
{
	int i = 0;
	for (i = 0; i < 10; i++)
	{
		if (0 == a[i] % 2)
		{
			printf("%d ", a[i]);
		}
		else
			printf("%d ", a[i]);
	}
}

int main()
{
	int arr[10] = { 0 };
	int i = 0;
	printf("Please iuput some numbers:\n");
	for (i = 0; i < 10; i++)
	{
		scanf("%d", &arr[i]);
	}
	Ofirst(arr);
	system("pause");
	return 0;
}