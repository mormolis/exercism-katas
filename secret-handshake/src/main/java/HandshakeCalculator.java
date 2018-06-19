import java.util.LinkedList;
import java.util.List;

class HandshakeCalculator {
    LinkedList<Signal> message;
    public HandshakeCalculator(){
        this.message = new LinkedList<>();
    }

    List<Signal> calculateHandshake(int number) {

        number = Integer.parseInt(Integer.toBinaryString(number));

        boolean reverse = false;
        if (number/10_000 > 0) {
            reverse = true;
            number %= 10_000;
        }

        if(number/1000 > 0){
            addToRightPlace(reverse,Signal.JUMP);
            number %= 1000;
        }

        if(number/100 > 0){
            addToRightPlace(reverse,Signal.CLOSE_YOUR_EYES);
            number %= 100;
        }

        if(number/10 > 0){
            addToRightPlace(reverse,Signal.DOUBLE_BLINK);
            number %= 10;
        }

        if (number > 0) {
            addToRightPlace(reverse,Signal.WINK);
        }

        System.out.println(message);
        return message;
    }

    private void addToRightPlace(boolean reverse, Signal mes){
        if(reverse) {
            message.add(mes);
        } else {
            message.addFirst(mes);
        }
    }

}
