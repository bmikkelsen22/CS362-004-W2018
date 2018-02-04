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

    printf("Testing smithy:\n");
    cardEffect(smithy, 0, 0, 0, state, 4, 0);
    printf("3 cards drawn? ");
    check(state->handCount[0], 7);
    printf("Which cards were drawn?---\n");
    check(state->hand[0][4], 4);
    check(state->hand[0][5], 4);
    check(state->hand[0][6], 4);
    
    
    return 0;
}