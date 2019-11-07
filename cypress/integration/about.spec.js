describe('About us Test', function () {
    beforeEach(function () {
        cy.visit('localhost:8080/about');
    });
    it('Get Title', function () {
        cy.title().should('eq', 'About Us');
    });
    it('Has project members', function () {
        cy.get('.title--team').should('have.text', 'OUR TEAM: Mariia, Maksim, Arthur')
    });
    it('Has time', function () {
        cy.contains('time is');
    });
    it('Has names of personas text info', function () {
        cy.get('.person--info h2').should('not.be.empty');
    });
    it("Has word goals", function () {
        cy.get('.person--info h3').should('have.text', 'Goals:Goals:')
    });
    it('Has goals text info', function () {
        cy.get('.person--info p').should('not.be.empty');
    });
});