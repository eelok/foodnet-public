describe('About us Test', function () {
    beforeEach(function () {
        cy.visit('localhost:8080/createRecipes');
    });
    it('Get Title', function () {
        cy.title().should('eq', 'Create Recipes');
    });

});