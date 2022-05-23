package BinPacking;

public class BinMain {
    public static void main(String[] args) {
        BinPacker packer = new BinPacker(5, 1000);
        packer.print();
        System.out.println(packer.addBlock('r'));
        System.out.println(packer.addBlock('b'));
        System.out.println(packer.addBlock('b'));
        System.out.println(packer.addBlock('b'));
        System.out.println(packer.addBlock('b'));
        System.out.println(packer.addBlock('b'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        System.out.println(packer.addBlock('g'));
        packer.addBlock('r');
        packer.print();
    }
}
