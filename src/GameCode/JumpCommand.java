package GameCode;


class JumpCommand implements PlayerCommand {
    private Player player;
    private int jumpForce;

    public JumpCommand(int jumpForce) {
        this.jumpForce = jumpForce;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (!player.inAir) {
            player.inAir = true;
            player.yVelocity = -jumpForce;
        }
    }
}