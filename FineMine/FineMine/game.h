#ifndef _GAME_H
#define _GAME_H

#define ROWS ROW+2
#define COLS COL+2
#define ROW 9
#define COL 9
#define Count 10

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<time.h>

void menu();

void game();

void InitBoard(char arr[ROWS][COLS],char ch);

void DisplayBoard(char arr[ROWS][COLS]);

void SetMine(char arr[ROWS][COLS]);

void FindMine(char arr1[ROWS][COLS], char arr2[ROWS][COLS]);

void FirstAlive(char arr[ROWS][COLS],int m,int n,int* p);

void IfOpen(char arr1[ROWS][COLS], char arr2[ROWS][COLS], int x, int y,int*p);

int GetMineCount(char arr[ROWS][COLS], int x, int y);

#endif _GAME_H
