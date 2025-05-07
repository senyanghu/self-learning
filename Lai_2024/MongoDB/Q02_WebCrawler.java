package MongoDB;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/web-crawler-multithreaded/solutions/419264/java-streams-concurrenthashmap-60-ms

interface HtmlParser {
    public List<String> getUrls(String url);
}

public class Q02_WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        return crawl(startUrl, htmlParser, hostname, visited).collect(Collectors.toList());
    }

    private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
        Stream<String> stream = htmlParser.getUrls(startUrl)
                .parallelStream()
                .filter(url -> isSameHostname(url, hostname))
                .filter(url -> visited.add(url))
                .flatMap(url -> crawl(url, htmlParser, hostname, visited));

        return Stream.concat(Stream.of(startUrl), stream);
    }

    /**
     * // 例子 1:
     * url = "http://leetcode.com/problems"
     * //     0123456789
     * //     ----7----
     * idx = url.indexOf('/', 7) // 返回 17
     * result = "http://leetcode.com"
     * <p>
     * // 例子 2:
     * url = "http://leetcode.com"
     * idx = url.indexOf('/', 7) // 返回 -1
     * result = "http://leetcode.com"
     */
    private String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx == -1) ? url : url.substring(0, idx);
    }

    private boolean isSameHostname(String url, String hostname) {
        if (url.startsWith(hostname)) {
            return true;
        }
        return false;
    }
}
