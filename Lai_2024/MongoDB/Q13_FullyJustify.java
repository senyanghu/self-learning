package MongoDB;

import java.util.ArrayList;
import java.util.List;


public class Q13_FullyJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            // 找出当前行可以放下的单词
            int count = 1; // 当前行的单词数
            int lastIndex = index; // 当前行的最后一个单词的索引
            int lineLength = words[index].length(); // 当前行单词总长度（不包括空格）

            // 尽可能多地添加单词
            while (lastIndex + 1 < words.length) {
                if (lineLength + 1 + words[lastIndex + 1].length() <= maxWidth) {
                    lineLength += 1 + words[lastIndex + 1].length(); // +1是单词间的空格
                    lastIndex++;
                    count++;
                } else {
                    break;
                }
            }

            StringBuilder builder = new StringBuilder();

            // 最后一行或只有一个单词的情况：左对齐
            if (lastIndex == words.length - 1 || count == 1) {
                for (int i = index; i < lastIndex; i++) {
                    builder.append(words[i]).append(" ");
                }
                builder.append(words[lastIndex]);

                // 在末尾添加空格以达到maxWidth
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            }
            // 正常行：需要均匀分布空格
            else {
                // 计算空格
                int spaces = maxWidth - lineLength + count - 1; // 总空格数
                int gaps = count - 1; // 间隙数
                int spacesPerGap = gaps == 0 ? 0 : spaces / gaps; // 每个间隙的基本空格数
                int extraSpaces = gaps == 0 ? 0 : spaces % gaps; // 需要额外分配的空格数

                for (int i = index; i < lastIndex; i++) {
                    builder.append(words[i]);

                    // 添加空格
                    int spacesToAdd = spacesPerGap + (i - index < extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        builder.append(" ");
                    }
                }
                builder.append(words[lastIndex]);
            }

            result.add(builder.toString());
            index = lastIndex + 1;
        }

        return result;
    }
}
