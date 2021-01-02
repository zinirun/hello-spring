package zini.hellospring.domain;

public class Member {
    private Long id;
    private String name;

    // Getter, Setter 자동생성 -> Alt + Insert
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
