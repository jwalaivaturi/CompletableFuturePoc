package com.example.demo;


public class Registration {
    private String name;
    private String id;
    
    public Registration( String name, String id )
    {
        this.name = name;
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }
    public String getId()
    {
        return id;
    }
    public void setId( String id )
    {
        this.id = id;
    }
    @Override
    public String toString()
    {
        return "Registration [id=" + id + ", name=" + name + "]";
    }
    

}
