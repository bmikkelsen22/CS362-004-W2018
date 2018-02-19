#include "dominion.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

int rng(int min, int max) {
    return rand() % (max + 1 - min) + min;
}

int main() {
    srand(time(NULL));
    int i;
    printf("Testing Village:\n");
    for (i = 0; i < 100; i++) {
        struct gameState* state = newGame();
        int* cards = kingdomCards(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        initializeGame(4, cards, rng(100, 12349), state);

        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);
        gainCard(rng(1, 10), state, 1, 0);

        printf("Testing village:\n");
        cardEffect(village, 0, 0, 0, state, rng(0, state->handCount[0]), 0);
        printf("1 card drawn? ");
        check(state->handCount[0], 5);
        printf("Which card was drawn? ");
        check(state->hand[0][4], 4);
        printf("Actions increased by 2? ");
        check(state->numActions, 3);
    }
    
    return 0;
}