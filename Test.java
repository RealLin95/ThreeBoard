package bittech;

public class Test {
    public static void main(String[] args){
        Sequence sequence = new SequenceArrayImpl(2);
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        System.out.println(sequence.size());
        System.out.println(sequence.get(0));
        System.out.println(sequence.change(0,20));
        System.out.println(sequence.get(0));
        System.out.println(sequence.contains(20));
        System.out.println(sequence.contains(null));
        System.out.println(sequence.remove(0));
        System.out.println(sequence.size());
        sequence.clear();
    }
}
