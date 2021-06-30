import bots.TerranRushBot;
import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.github.ocraft.s2client.protocol.game.Race;

import java.nio.file.Paths;

public class Titanium {


    public static void main(String[] args) {

        S2Coordinator s2Coordinator = S2Coordinator.setup()
                .loadSettings(args)
                .setRealtime(true)
                .setParticipants(
                        S2Coordinator.createParticipant(Race.TERRAN, new TerranRushBot()),
                        S2Coordinator.createComputer(Race.ZERG, Difficulty.MEDIUM))
                .launchStarcraft();

        s2Coordinator.startGame(LocalMap.of(Paths.get("D:\\Programs\\StarCraft II\\Maps\\Ladder2017Season1\\AbyssalReefLE.SC2Map")));
        //s2Coordinator.startGame(BattlenetMap.of("AbyssalReefLE"));




        while (s2Coordinator.update()) {

        }

        s2Coordinator.quit();
    }


}
