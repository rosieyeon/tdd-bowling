package tdd.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    private BowlingGame bowlingGame = new BowlingGame();

    @Test
    @DisplayName("플레이어는 모든 프레임의 각 투구에서 0점을 기록한다")
    void gutterGame() {
        //given: 게임을 진행하는 동안

        //when: 모든 투구에서 하나의 핀도 쓰러뜨리지 못하면
        for (int round=1; round <=10; round++) {
            for (int i =1; i<=2; i++) {
                int pin = 0;
                bowlingGame.roll(pin);
            }
        }

        //then: 점수는 0이 된다
        assertEquals(0, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 첫 프레임의 첫 투구에서 1점을 록하고 나머지는 모두 0점을 기록한다")
    void onePin() {
        //given: 게임을 진행하는 동안
        bowlingGame.roll(1);
        bowlingGame.roll(0);

        //when: 첫 투구에서 1점을 기록하고 나머지는 모두 0점을 기록하면
        for(int round = 2; round<=10; round++) {
            for (int i=1; i<=2; i++) {
                int pin = 0;
                bowlingGame.roll(pin);
            }
        }

        //then: 점수는 1점이 된다
        assertEquals(1, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 각 투구에서 최소 0개에서 최대 10개까지의 핀을 쓰러트릴 수 있다")
    void accurateBowlingMaxTen() {
        //given: 게임을 진행하는 동안


        //when: 투구에서 10개보다 많은 핀을 쓰러트리면

        //then: 런타임에러(illegalArgumentException)가 발생한다
        assertThrows(IllegalArgumentException.class, ()-> bowlingGame.roll(11));
    }

    @Test
    @DisplayName("플레이어는 각 투구에서 최소 0개에서 최대 10개까지의 핀을 쓰러트릴 수 있다")
    void accurateBowlingMinZero() {
        //given: 게임을 진행하는 동안


        //when: 투구에서 0개보다 적은 핀을 쓰러트리면

        //then: 런타임에러(illegalArgumentException)가 발생한다
        assertThrows(IllegalArgumentException.class, ()-> bowlingGame.roll(-1));
    }

    @Test
    @DisplayName("플레이어의 투구에서 스페어가 발생한다")
    void spare() {
        //given: 게임을 진행하는 동안 첫 번째 투구에서 7개의 핀을 쓰러트리고
        bowlingGame.roll(7);

        //when: 두 번째 투구에서 나머지 3개의 핀을 쓰러트려 스페어를 한다면
        bowlingGame.roll(3);
        bowlingGame.roll(6);
        for (int i=0; i<17; i++) {
            bowlingGame.roll(0);
        }

        //then: 다음 투구에서 쓰러트린 핀의 갯수만큼 보너스 점수를 받는다. (Out of Scope: strike)
        assertEquals(22, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 첫 프레임에서 스트라이크를 기록하고 다음과 같은 점수를 얻는다")
    void singleStrike() {
        // given : 게임을 진행하는 동안

        // when : 첫 프레임에서 스트라이크를 기록한다.
        // 두번째 프레임의 투구들은 각 1점을 기록한다
        // 나머지 프레임은 0점을 기록한다
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        for (int i = 0; i < 16; i++) {
            bowlingGame.roll(0);
        }

        // then : 점수는 14점이 된다
        assertEquals(14, bowlingGame.score());
    }

    @Test
    @DisplayName("플레이어는 각 프레임에서 2번의 투구의 합이 최소 0개엣서 최대 10개까지의 핀을 쓰러트릴 수 있다")


    @Test
    void roll() {
    }

    @Test
    void score() {
    }
}