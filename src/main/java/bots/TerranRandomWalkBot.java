package bots;

import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.protocol.data.Abilities;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.Race;
import com.github.ocraft.s2client.protocol.unit.Alliance;

public class TerranRandomWalkBot extends S2Agent {

        @Override
        public void onGameStart() {
            System.out.println("Hello world of Starcraft II bots!");
        }

        @Override
        public void onStep() {
            long gameLoop = observation().getGameLoop();

            if (gameLoop % 100 == 0) {

                observation().getUnits(Alliance.SELF).forEach(unitInPool ->
                        actions().unitCommand(
                                unitInPool.unit(),
                                Abilities.SMART,
                                observation().getGameInfo().findRandomLocation(), false));
            }
        }


}