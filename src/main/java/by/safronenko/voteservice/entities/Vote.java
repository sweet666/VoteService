package by.safronenko.voteservice.entities;


import javax.persistence.*;

/**
 * Entity VOTE
 */
@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FIRST_OPTION")
    private String first_option;

    @Column(name = "SECOND_OPTION")
    private String second_option;

    //Параметр "is_open" принимает значения "open" (если голосование активно) или
    // "closed" (если голосование завершено)
    @Column(name = "IS_OPEN")
    private String is_open;

    //Параметр "link" хранит ссылку на голосование
    @Column(name = "LINK")
    private String link;

    // Счетчики голосов для перового и второго варианта ответов
    @Column(name = "FIRST_COUNTER")
    private int first_counter;

    @Column(name = "SECOND_COUNTER")
    private int second_counter;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_option() {
        return first_option;
    }

    public void setFirst_option(String first_option) {
        this.first_option = first_option;
    }

    public String getSecond_option() {
        return second_option;
    }

    public void setSecond_option(String second_option) {
        this.second_option = second_option;
    }

    public String getIs_open() {
        return is_open;
    }

    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getFirst_counter() {
        return first_counter;
    }

    public void setFirst_counter(int first_counter) {
        this.first_counter = first_counter;
    }

    public int getSecond_counter() {
        return second_counter;
    }

    public void setSecond_counter(int second_counter) {
        this.second_counter = second_counter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vote other = (Vote) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
