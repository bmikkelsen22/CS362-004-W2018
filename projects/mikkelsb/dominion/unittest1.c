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
    int* result = kingdomCards(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    printf("Testing kingdomCards():\n");
    int i;
    for (i = 0; i < 10; i++) {
        check(result[i], i + 1);
    }

    return 0;
}