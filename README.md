## Synopsis

Android MVP architecture is introduce for make a project flexible, maintainable and easily apply Unit test.
In MVP presenter assume the functionality of the middle man . In MVP all core logic pushed to presentation layer.

Model : It's give a flexibility of how data stored and retrieved . Presentation layer responsible for fetch data from the model
        and provide to a view layer.

View :  It's display data and routes user event to presentation layer.

Presentation : It's middle layer it always keep communicate between model and view layer. It retrive a data from the model and formate it for display in the view.
               Business logic live in the presenter and relies on the view to do Android work.



## Code Example
step 1: create interface  for your view ```IMyView.java```
         
         public interface IMyView {
                 void showItems(List<String> items);
           }         
           
step 2: create interface for your presentation ```IMyServices.java ``` it will notify when long running task finish.
        
        
         public interface IMyServices {
                List<String> getItems();
          }
step 3: create class ```MyContentServices.java ``` usally it's include your long running operation that notify your presenter by                 implement ```IMyServices.java ```.
    
    public class MyContentServices implements IMyServices {
       @Override
       public List<String> getItems() {
         ArrayList<String> items = new ArrayList<>();
         items.add("one");
         items.add("two");
         items.add("three");
         items.add("four");
         return items;
       }
    }
 step 4: Implement ```IMyView.java``` to your ```Activity``` or ```Fragment``` class it will override ```showItems(List<String> items)``` method in Activity.
      
  
 step 5: Now merge all your step into ```Activity.java``` file at any event of your specific view.
          
      private  MyPresenter presenter;
      presenter = new MyPresenter(this, new MyContentServices());
        
        @OnClick(R.id.btnLoad)
           public void loadItems() {
               presenter.load();
           }
         
               
## Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Installation

Provide code examples and explanations of how to get the project.

##  Reference
I am very thankful to this reference:

- https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter
- http://www.infragistics.com/community/blogs/todd_snyder/archive/2007/10/17/mvc-or-mvp-pattern-whats-the-difference.aspx
- http://antonioleiva.com/mvp-android/
- https://github.com/googlesamples/android-architecture

## Tests

Describe and show how to run the tests with code examples.

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

```
Copyright 2016 by Altaf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
