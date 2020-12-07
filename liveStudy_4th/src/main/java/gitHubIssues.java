public class githubReadMe {

    public int sum(int x, int y){
        return x+y;
    }
    
    GitHub github = GitHub.connect();

    GHRepository repo = github.createRepository(
            "new-repository","this is my new repository",
            "https://www.kohsuke.org/",true/*public*/);
repo.addCollaborators(github.getUser("abayer"),github.getUser("rtyler"));
repo.delete();
    public static void main(String[] args) {
        githubReadMe model = new githubReadMe();
        System.out.println(model.sum(5,6));
        System.out.println("here");
    }
}
