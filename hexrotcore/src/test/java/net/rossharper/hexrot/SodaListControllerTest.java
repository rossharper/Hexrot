package net.rossharper.hexrot;

import net.rossharper.hexrot.model.Price;
import net.rossharper.hexrot.model.Soda;
import net.rossharper.hexrot.model.Volume;
import net.rossharper.hexrot.sodadetails.SodaDetailsScreenDisplayEventFactory;
import net.rossharper.hexrot.sodalist.SodaList;
import net.rossharper.hexrot.sodalist.SodaListController;
import net.rossharper.hexrot.sodaprovider.SodaListProvider;
import net.rossharper.hexrot.sodaprovider.SodaListProviderListener;
import net.rossharper.hexrot.sodalist.SodaListView;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SodaListControllerTest {
    @Test
    public void whenControllerOnReady_thenSodaListGivenToView() {
        // Arrange
        SodaListView mockView = mock(SodaListView.class);
        SodaListProvider sodaListProvider = createSodaListProviderFixture();

        // Act
        SodaListController sut = new SodaListController(mockView, sodaListProvider, mock(SodaDetailsScreenDisplayEventFactory.class));
        sut.onReady();

        // Assert
        verify(mockView).displaySodaList(argThat(matchesSodaListFixture()));
    }

    private Matcher<SodaList> matchesSodaListFixture() {
        return new SodaListMatcher();
    }

    private class SodaListMatcher extends ArgumentMatcher<SodaList> {
        @Override
        public boolean matches(Object argument) {
            SodaList actual = (SodaList)argument;
            SodaList expected  = createSodaListFixture();
            return SodaListsMatch(expected, actual);
        }
        
        private boolean SodaListsMatch(SodaList expected, SodaList actual) {
            boolean match = false;
            if(expected.size() == actual.size()) {
                match = true;
                for(int i = 0; i < expected.size() && match; ++i) {
                    Soda expectedSoda = expected.get(i);
                    Soda actualSoda = actual.get(i);
                    match = expectedSoda.getName().equals(actualSoda.getName());
                }
            }
            return match;
        }
    }


    private SodaListProvider createSodaListProviderFixture() {
        return new SodaListProvider() {
            @Override
            public void getSodas(SodaListProviderListener SodaListProviderListener) {
                SodaListProviderListener.sodaListReceived(createSodaListFixture());
            }
        };
    }

    private SodaList createSodaListFixture() {
        List<Soda> sodaList = new ArrayList<Soda>();
        sodaList.add(createSodaFixture("Dr Salt"));
        sodaList.add(createSodaFixture("Big Red Cola"));
        sodaList.add(createSodaFixture("Hill Mist"));

        return new SodaList(sodaList);
    }

    private Soda createSodaFixture(final String sodaName) {
        return new Soda() {
            @Override
            public String getName() {
                return sodaName;
            }

            @Override
            public Price getPrice() {
                return Price.fromGbpPence(1);
            }

            @Override
            public Volume getVolume() {
                return Volume.fromMillilitres(1);
            }
        };
    }
}
