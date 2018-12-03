#define  _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
unsigned int reverse_bit(unsigned int n)
{
	int x = 0;
	int i = 0;
    double ret = 0;
	for (i = 0; i < 32; i++)
	{
		x = (n >> i) & 1;
		ret += x*pow(2, (31 - i));
	}
	return ret;
}
int main()
{
	int num = 0;
	int i = 0;
    double sum = 0;
	printf("Please input a number:");
	scanf("%d", &num);
	sum = reverse_bit(num);
	printf("%f\n",sum);
	system("pause");
	return 0;
}


#include<stdio.h>
#include<stdlib.h>
int main()
{
	int a = 0;
	int b = 0;
	float c = 0;
	printf("Please input a and b:");
	scanf("%d %d", &a, &b);
	c = (a - b) / 2 + b;
	printf("The average of a and b is :%d\n", c);
	system("pause");
	return 0;
}


#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
	int i = 0;
	int ret = 0;
	int arr[9] = { 0 };
	printf("please iuput some numbers:\n");
	for (i = 0; i < 9; i++)
	{
		scanf("%d", &arr[i]);
	}
	for (i = 0; i < 9; i++)
	{
		ret = ret^arr[i];
	}
	printf("%d\n", ret);
	system("pause");
	return 0;
}


#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
int m_strlen(char* p)
{
	char* s = p;
	while (*p != '\0')
		p++;
	return(p - s);
}

void Reverse(char* p, char* p1)
{
	char temp = 0;
	assert(p&&p1);
	while (p < p1)   //中间为分界线，两边交换字符
	{
		temp = *p;
		*p = *p1;
		*p1 = temp;
		p++;
		p1--;
	}
}

int main()
{
	char arr[] = "I am a student";
	char* p = arr;
	int l = m_strlen(p) - 1;
	char* p1 = p+l;
	Reverse(p,p1);
	printf("%s\n", arr);
	system("pause");
	return 0;
}