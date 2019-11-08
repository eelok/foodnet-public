describe('Recipes Page Test', function () {
    beforeEach(function () {
        cy.visit('localhost:8080/recipes');
    });
    it('Get Title', function () {
        cy.title().should('eq', 'recipes');
    });
});