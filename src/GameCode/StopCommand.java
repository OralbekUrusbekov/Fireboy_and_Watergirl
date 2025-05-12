package GameCode;

class StopCommand implements PlayerCommand {
    private Player player;

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.xVelocity = 0;
    }
}