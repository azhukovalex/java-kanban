package main.models;


public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected main.models.Status state;
    protected TaskType taskType;
    
    //Constructors
    public Task(int id, String name, String description, main.models.Status state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.state = main.models.Status.NEW;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public main.models.Status getStatus() {
        return state;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(main.models.Status status) {
        this.state = status;
    }
    
    //Overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task other)) return false;

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}

