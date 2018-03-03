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

    printf("Testing council room:\n");
    cardEffect(council_room, 0, 0, 0, state, 4, 0);
    printf("4 card drawn (-1 for discard)? ");
    check(state->handCount[0], 8);
    printf("Buys increased? ");
    check(state->numBuys, 2);
    printf("Everyone else draws card? \n");
    check(state->handCount[1], 1);
    check(state->handCount[2], 1);
    check(state->handCount[3], 1);

    return 0;
}