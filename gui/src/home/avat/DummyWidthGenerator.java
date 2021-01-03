package home.avat;

public abstract class DummyWidthGenerator {

    public static DummyWidthGenerator create() {
        return new ExponentialGenerator();
    }

    public abstract int getNext();

    private static class ExponentialGenerator extends DummyWidthGenerator
    {
        public int getNext() {
            _currentNo ++;
            return compute(_currentNo);
        }

        private int _currentNo = 0;

        private static int compute(int no) {
            var source = Math.exp(no);
            source = Math.round(1000 * (source - Math.floor(source)));
            return 100 + 50 * (((int) source) % 7);
        }
    }
}
