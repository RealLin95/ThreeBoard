#ifndef _GAME_H
#define _GAME_H
#define row 3
#define col 3
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
void menu();

void game();

void InitBoard(char board[row][col]);

void DisplayBoard(char board[row][col]);

void PlayerMove(char board[row][col]);

void ComputerMove(char board[row][col]);

char IsWin(char board[row][col]);

int IsFull(char board[row][col]);


#endif _GAME_H