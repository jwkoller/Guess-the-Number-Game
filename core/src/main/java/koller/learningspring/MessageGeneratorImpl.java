package koller.learningspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    //-- fields --
    private final Game game;

    //-- constructors --
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    //-- init methods --
    @PostConstruct
    private void GameValue(){
        log.info("game = {}", game);
    }

    // -- Public Methods --
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        String message;

        if(game.isGameWon()){
            message = "You guess it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            message = "You lost. The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            message = "Invalid number range.";
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            message = "What is your first guess?";
        }else{
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }

            message = direction + "! You have " + game.getRemainingGuesses() + " guesses left.";
        }
        return message;
    }
}
