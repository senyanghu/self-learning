package A_12_Sampling;

// 序列：[A, B, C, D]
// 分析B(第2个元素)被选为最终样本的概率
// 当C到达时(第3个元素)：
// B不被C替换的概率是 (1-1/3)，即 2/3
//
// 当D到达时(第4个元素)：
// B不被D替换的概率是 (1-1/4)，即 3/4
// B最终被选中的概率 = 初始被选中概率 × 保持概率
// = (1/2) × (2/3) × (3/4)
// = 1/4
// P(B最终被选中) = P(B初始被选中) × P(不被C替换) × P(不被D替换)
//                = (1/2) × (1-1/3) × (1-1/4)
//                = (1/2) ×  (2/3) × (3/4)
//                = 1/4
public class Q02_ReservoirSampling {
    private int count;
    private Integer sample;

    public Q02_ReservoirSampling() {
        this.count = 0;
        this.sample = null;
    }

    public void read(int value) {
        this.count++;
        int prob = (int) (Math.random() * count);
        if (prob == 0) {
            this.sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
