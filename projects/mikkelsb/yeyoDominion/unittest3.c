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

    printf("Testing gainCard: to deck\n");
    gainCard(smithy, state, 1, 0);
    printf("Card added to deck? ");
    check(state->deckCount[0], 5);
    printf("Card was smithy? ");
    check(state->deck[0][4], 4);
    printf("Smithy supply decreased? ");
    check(state->supplyCount[smithy], -1);

    printf("Testing gainCard: to discard\n");
    gainCard(smithy, state, 0, 0);
    printf("Card added to discard? ");
    check(state->discardCount[0], 0);
    printf("Card was smithy? ");
    check(state->discard[0][4], 0);
    printf("Smithy supply decreased? ");
    check(state->supplyCount[smithy], -1);
    
    return 0;
}