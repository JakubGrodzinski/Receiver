package pl.coderslab.receiver.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import pl.coderslab.receiver.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class CountOddsService
{
    @Async
    Future<List<Double>> countOdds (Event event)
    {
        // 0 - home, 1 - away, 2 - draw
        List<Double> result = new ArrayList<>();
        int attack1 = event.getTeam1().getAttackPotential();
        int attack2 = event.getTeam2().getAttackPotential();
        int defence1 = event.getTeam1().getDefencePotential();
        int defence2 = event.getTeam2().getDefencePotential();
        int goals1 = event.getTeam1score();
        int goals2 = event.getTeam2score();
        double allProbability =(double) (attack1 + attack2 + defence1 + defence2 + goals1 * 20 + goals2 * 20);
        double home = 0.8 * (double) attack1 + 0.8 * (double) defence1 + 16 * goals1;
        double away = 0.8 * (double) attack2 + 0.8 * (double) defence2 + 16 * goals2;
        double draw = 0.2 * (double)(attack1 + attack2 + defence1 + defence2) + 4 * (goals1 + goals2);
        Double probability_home = new Double(home/allProbability);
        Double probability_away = new Double(away/allProbability);
        Double probability_draw = new Double(draw/allProbability);
        result.add(home);
        result.add(away);
        result.add(draw);
        return new AsyncResult<List<Double>>(result);
    }
}
