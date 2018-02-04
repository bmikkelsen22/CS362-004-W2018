#include "dominion.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

int check(int a, int b) {
    printf("Comparing %d to %d... ", a, b);
    if (a == b) {
        printf("TEST PASSED\n");
        return 1;
    } else {
        printf("TEST FAILED\n");
        return 0;
    }
}

int main() {
    struct gameState* state = newGame();
    int* cards = kingdomCards(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    initializeGame(4, cards, 1234, state);

    printf("Testing village:\n");
    cardEffect(village, 0, 0, 0, state, 4, 0);
    printf("1 card drawn? ");
    check(state->handCount[0], 5);
    printf("Which card was drawn? ");
    check(state->hand[0][4], 4);
    printf("Actions increased by 2? ");
    check(state->numActions, 3);
    
    return 0;
}