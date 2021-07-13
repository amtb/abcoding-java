import java.util.*;

/**
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
  static class Email {
    String name, email;

    public Email(String n, String e) {
      name = n;
      email = e;
    }
  }

  static class AccountsGraph {
    Map<String, List<Email>> accounts = new HashMap<>();

    void addEmail(Email e) {
      List<Email> emails = accounts.getOrDefault(e.email, new LinkedList<>());
      emails.add(e);
      accounts.put(e.email, emails);
    }

    void addEmails(Email e1, Email e2) {
      List<Email> emails1 = accounts.getOrDefault(e1.email, new LinkedList<>());
      emails1.add(e2);
      accounts.put(e1.email, emails1);

      List<Email> emails2 = accounts.getOrDefault(e2.email, new LinkedList<>());
      emails2.add(e1);
      accounts.put(e2.email, emails2);
    }
  }

  static class DFS {
    private final Queue<String> queue;
    Set<String> visited;

    DFS(AccountsGraph g, String e) {
      visited = new HashSet<>();
      queue = new PriorityQueue<>((l, r) -> l.compareToIgnoreCase(r));
      dfs(g, e);
    }

    private void dfs(AccountsGraph g, String e) {
      visited.add(e);
      queue.offer(e);

      for (Email email : g.accounts.get(e)) {
        if (!visited.contains(email.email)) {
          dfs(g, email.email);
        }
      }
    }
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    AccountsGraph g = new AccountsGraph();

    for (List<String> account : accounts) {
      String name = account.get(0);
      if (account.size() == 2) {
        g.addEmail(new Email(name, account.get(1)));
      } else {
        List<Email> emails = new ArrayList<>();
        for (int i = 1; i < account.size(); i++) emails.add(new Email(name, account.get(i)));
        for (int i = 1; i < emails.size(); i++) g.addEmails(emails.get(i - 1), emails.get(i));
      }
    }

    List<List<String>> results = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    for (Map.Entry<String, List<Email>> accountEntry : g.accounts.entrySet()) {
      String email = accountEntry.getKey();

      if (!visited.contains(email)) {
        DFS dfs = new DFS(g, email);
        visited.addAll(dfs.visited);

        List<String> result = new LinkedList<>();
        result.add(accountEntry.getValue().get(0).name);

        Queue<String> q = dfs.queue;

        while (!q.isEmpty()) {
          result.add(q.poll());
        }

        results.add(result);
      }
    }

    return results;
  }
}
