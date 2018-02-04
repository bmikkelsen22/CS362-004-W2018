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

    printf("Testing discardCard:\n");
    discardCard(0, 0, state, 1);
    printf("Played card set to -1? ");
    check(state->hand[0][0], -1);
    printf("Played hand count decreased? ");
    check(state->handCount[0], 4);
    
    return 0;
}