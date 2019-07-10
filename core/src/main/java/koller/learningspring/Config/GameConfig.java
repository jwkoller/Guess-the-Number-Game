package koller.learningspring.Config;

import koller.learningspring.GuessCount;
import koller.learningspring.MaxNumber;
import koller.learningspring.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "koller.learningspring")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    //-- fields --
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:1}")
    private int minNumber;

    //-- bean methods --
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
