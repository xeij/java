public class oddsArray{

    public static void main(String[] args){

    int elm = 0;
    int[] odds = new int[22];
    for(int i=-6; i<=38; i++){
    if(i%2!=0){
        odds[elm]=i;
        elm++;
            }
        }
    }
}