package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.errs.BookstoreApiWrongParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BookServiceTests {

    @Mock
    private BookRepository bookRepositoryMock;
    private BookService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BookService(bookRepositoryMock);
    }

    @Test
    void getBooksByAuthorTest() {
        String authorName = "Ann";
        underTest.getBooksByAuthor(authorName);
        ArgumentCaptor<String> authorNameCaptor = ArgumentCaptor.forClass(String.class);
        verify(bookRepositoryMock.findBooksByAuthorFirstNameContaining(authorNameCaptor.capture()));
        String capturedAuthorName = authorNameCaptor.getValue();
        assertThat(capturedAuthorName).isEqualTo(authorName);
    }

    @Test
    void getBooksByTitleTest() throws BookstoreApiWrongParameterException {
        String title = "Forest";
        underTest.getBooksByTitle(title);
        ArgumentCaptor<String> titleCaptor = ArgumentCaptor.forClass(String.class);
        verify(bookRepositoryMock.findBooksByTitleContaining(titleCaptor.capture()));
        String capturedTitle = titleCaptor.getValue();
        assertThat(capturedTitle).isEqualTo(title);
    }

    @Test
    void getBooksWithPriceBetweenTest() {
        Integer minPrice = 222;
        Integer maxPrice = 555;
        underTest.getBooksWithPriceBetween(minPrice, maxPrice);
        ArgumentCaptor<Integer> minPriceCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> maxPriceCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(bookRepositoryMock.findBooksByPriceOldBetween(minPriceCaptor.capture(), maxPriceCaptor.capture()));
        Integer capturedMinPrice = minPriceCaptor.getValue();
        Integer capturedMaxPrice = maxPriceCaptor.getValue();
        assertThat(capturedMinPrice).isEqualTo(minPrice);
        assertThat(capturedMaxPrice).isEqualTo(maxPrice);
    }

    @Test
    void getBooksWithPriceTest() {
        Integer price = 555;
        underTest.getBooksWithPrice(price);
        ArgumentCaptor<Integer> priceCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(bookRepositoryMock.findBooksByPriceOldIs(priceCaptor.capture()));
        Integer capturedPrice = priceCaptor.getValue();
        assertThat(capturedPrice).isEqualTo(price);
    }

    @Test
    void getBooksWithMaxPriceTest() {
        underTest.getBooksWithMaxPrice();
        verify(bookRepositoryMock).getBooksWithMaxDiscount();
    }

    @Test
    void getBestsellersTest() {
        underTest.getBestsellers();
        verify(bookRepositoryMock).getBestsellers();
    }
}