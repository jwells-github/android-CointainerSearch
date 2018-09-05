package containersearch.jaked.containersearch;

public class ContainerNumber {

    String mContainerNumber;

    public ContainerNumber(String containerNumber){
        mContainerNumber = containerNumber;
    }

    public String getContainerNumber() {
        return mContainerNumber;
    }

    public Boolean isValid(){
        String[] containerNumber = mContainerNumber.split("(?!^)");

        if(containerNumber.length != 11){
            return false;
        }

        for(int i = 0; i <= 3; i++){
            if(!Character.isLetter(containerNumber[i].charAt(0))){
                return false;
            }
        }

        for(int i = 4; i <= 9; i++){
            if(!Character.isDigit(containerNumber[i].charAt(0))){
                return false;
            }
        }

        int finalDigit = sumOfNumbers(containerNumber) % 11;

        if(containerNumber[10].equals(String.valueOf(finalDigit))){
            return true;
        }
        else{
            return false;
        }

    }

    private int sumOfNumbers(String[] containerNumber){
        int total = 0;
        for(int i =0; i <= 9; i++){
            double a = Math.pow(2,i);
            total += CharacterValue(containerNumber[i].charAt(0)) *  Math.pow(2,i);
        }
        return total;
    }

    private int CharacterValue(Character c){
        if(Character.isDigit(c)){
            return Integer.valueOf(c.toString());
        }
        else {
            c = Character.toLowerCase(c);
            int value = ((int) c ) - 87;
            value += (value + 1) / 11;
            return value;
        }
    }
}
