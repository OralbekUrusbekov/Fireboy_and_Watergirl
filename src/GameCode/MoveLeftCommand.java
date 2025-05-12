package GameCode;

class MoveLeftCommand implements PlayerCommand {
    private Player player;
    private int speed;

    public MoveLeftCommand(int speed) {
        this.speed = speed;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.xVelocity = -speed;
    }
}