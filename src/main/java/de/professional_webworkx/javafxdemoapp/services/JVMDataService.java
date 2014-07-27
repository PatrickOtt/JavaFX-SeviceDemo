/*
 * Copyright 2014 Your Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.professional_webworkx.javafxdemoapp.services;

import de.professional_webworkx.javafxdemoapp.domain.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.util.Duration;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class JVMDataService extends ScheduledService<List<Person>> {

    private final Random generator = new Random();

    public JVMDataService() {
        super();
    }

    
    @Override
    protected Task<List<Person>> createTask() {
        return new Task<List<Person>>() {

            @Override
            protected List<Person> call() throws Exception {
                int n = generator.nextInt(50);
                List<Person> persons = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    System.out.println("i = " + i);
                    persons.add(new Person("Max", "Mustermann", "max" + i + ".mustermann@example.com"));
                }
                return persons;
            }
        };
    };

}
