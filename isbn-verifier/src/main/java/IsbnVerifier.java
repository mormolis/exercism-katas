class IsbnVerifier {
    boolean isValid(String stringToVerify) {
        int sum = 0;
        int counter = 10;
        if(stringToVerify.isEmpty()) return false;
        for(int i=0; i<stringToVerify.length(); i++){
            if (counter <= 0) return false;
            if(stringToVerify.substring(i,i+1).equals("-")){
                continue;
            } else if(stringToVerify.substring(i,i+1).equals("X")){
                sum+=10;
            } else {
                try{
                    sum += Integer.parseInt(stringToVerify.substring(i,i+1)) * counter;
                } catch(Exception e){
                    return false;
                }
            }
            counter--;
        }
        if (counter > 0) return false;
        return sum % 11 == 0;
    }
}
