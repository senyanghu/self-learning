package MongoDB;


import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q98_WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = getHostName(startUrl);

        Set<String> visited = new HashSet<>();
        // BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Future> tasks = new LinkedList<>();

        queue.offer(startUrl);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        while (true) {
            String url = queue.poll();
            if (url != null) {
                if (getHostName(url).equals(hostName) && !visited.contains(url)) {
                    visited.add(url);
                    tasks.add(executor.submit(() -> {
                        List<String> newUrls = htmlParser.getUrls(url);
                        for (String newUrl : newUrls) {
                            queue.offer(newUrl);
                        }
                    }));
                }
            } else {
                if (!tasks.isEmpty()) {
                    Future nextTask = tasks.poll();
                    try {
                        nextTask.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    executor.shutdown();
                    break;
                }
            }
        }
        return new ArrayList<>(visited);
    }

    private String getHostName(String url) {
        url = url.substring(7);
        String[] parts = url.split("/");
        return parts[0];
    }
}
