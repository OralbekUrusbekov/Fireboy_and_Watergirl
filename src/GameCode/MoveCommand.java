package GameCode;

public class MoveCommand implements Command {
    private Player player;
    private int xVelocity;

    public MoveCommand(Player player, int xVelocity) {
        this.player = player;
        this.xVelocity = xVelocity;
    }

    @Override
    public void execute() {
        player.xVelocity = xVelocity;
    }
}
