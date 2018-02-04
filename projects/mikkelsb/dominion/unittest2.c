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

    printf("Testing updateCoins:\n");
    updateCoins(0, state, 7);
    check(state->coins, 11);

    updateCoins(1, state, 2);
    check(state->coins, 2);

    updateCoins(2, state, 0);
    check(state->coins, 0);
    
    return 0;
}